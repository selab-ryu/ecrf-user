package ecrf.user.search.researcher;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.model.Researcher;
import ecrf.user.service.ResearcherLocalService;

@Component(
    immediate = true,
    property = "indexer.class.name=ecrf.user.model.Researcher",
    service = ModelIndexerWriterContributor.class
)
public class ResearcherModelIndexerWriterContributor implements ModelIndexerWriterContributor<Researcher> {

	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable,
			ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		batchIndexingActionable.setPerformActionMethod((Researcher researcher) -> {
			Document document = modelIndexerWriterDocumentHelper.getDocument(researcher);
			batchIndexingActionable.addDocuments(document);		
		});
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(
				researcherLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(Researcher researcher) {
		return researcher.getCompanyId();
	}
	
	@Reference
    protected DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;

    @Reference
    protected ResearcherLocalService researcherLocalService;

}
