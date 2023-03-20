package ecrf.user.search.researcher;

import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.indexer.IndexerDocumentBuilder;
import com.liferay.portal.search.indexer.IndexerWriter;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.model.Researcher;

@Component(immediate = true, service = ResearcherBatchReindexer.class)
public class ResearcherBatchReindexerImpl implements ResearcherBatchReindexer {
	@Override
	public void reindex(long researcherId, long companyId) {
		BatchIndexingActionable batchIndexingActionable = indexerWriter.getBatchIndexingActionable();
		batchIndexingActionable.setAddCriteriaMethod(dynamicQuery -> {
			Property researcherIdProperty = PropertyFactoryUtil.forName("researcherId");
			dynamicQuery.add(researcherIdProperty.eq(researcherId));
		});
		
		batchIndexingActionable.setCompanyId(companyId);
		
		batchIndexingActionable.setPerformActionMethod((Researcher researcher) -> {
			Document document = indexerDocumentBuilder.getDocument(researcher);
			batchIndexingActionable.addDocuments(document);
		});
		
		batchIndexingActionable.performActions();
	}
	
	@Reference(
		target = "(indexer.class.name=ecrf.user.model.Researcher)"
	)
    protected IndexerDocumentBuilder indexerDocumentBuilder;

    @Reference(
		target = "(indexer.class.name=ecrf.user.model.Researcher)"
	)
    protected IndexerWriter<Researcher> indexerWriter;
}
