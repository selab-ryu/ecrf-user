package ecrf.user.search.researcher;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

import ecrf.user.constants.ECRFUserResearcherAttributes;

@Component(
    immediate = true,
    property = "indexer.class.name=ecrf.user.model.Researcher",
    service = ModelSummaryContributor.class
)
public class ResearcherModelSummaryContributor implements ModelSummaryContributor {

	@Override
	public Summary getSummary(Document document, Locale locale, String snippet) {
		Summary summary = createSummary(document);
		summary.setMaxContentLength(200);
		return summary;
	}
	
	private Summary createSummary(Document document) {
		String prefix = Field.SNIPPET + StringPool.UNDERLINE;
		String name = document.get(prefix+ECRFUserResearcherAttributes.NAME, ECRFUserResearcherAttributes.NAME);
		String email = document.get(prefix+ECRFUserResearcherAttributes.EMAIL, ECRFUserResearcherAttributes.EMAIL);
		String institution = document.get(prefix+ECRFUserResearcherAttributes.INSTITUTION, ECRFUserResearcherAttributes.INSTITUTION);
				
		String summaryTitle = name;
		String summaryContent = email + StringPool.SLASH + institution;
		return new Summary(summaryTitle, summaryContent);
	}
}
