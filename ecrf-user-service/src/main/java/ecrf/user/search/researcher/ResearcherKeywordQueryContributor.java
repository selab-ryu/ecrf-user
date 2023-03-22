package ecrf.user.search.researcher;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.constants.ECRFUserResearcherAttributes;

@Component(
    immediate = true,
    property = "indexer.class.name=ecrf.user.model.Researcher",
    service = KeywordQueryContributor.class
)
public class ResearcherKeywordQueryContributor implements KeywordQueryContributor {

	@Override
	public void contribute(String keywords, BooleanQuery booleanQuery,
			KeywordQueryContributorHelper keywordQueryContributorHelper) {
		
		SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();
		queryHelper.addSearchTerm(booleanQuery, searchContext, ECRFUserResearcherAttributes.NAME, true);
		queryHelper.addSearchTerm(booleanQuery, searchContext, ECRFUserResearcherAttributes.EMAIL, true);
		queryHelper.addSearchTerm(booleanQuery, searchContext, ECRFUserResearcherAttributes.INSTITUTION, true);
		queryHelper.addSearchTerm(booleanQuery, searchContext, ECRFUserResearcherAttributes.SCREEN_NAME, true);
	}
	
	@Reference
    protected QueryHelper queryHelper;
}
