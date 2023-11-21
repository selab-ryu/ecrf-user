package ecrf.user.search.researcher;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.constants.ECRFUserResearcherAttributes;
import ecrf.user.model.Researcher;

@Component(
    immediate = true,
    property = "indexer.class.name=ecrf.user.model.Researcher",
    service = ModelDocumentContributor.class
)
public class ResearcherModelDocumentContributor implements ModelDocumentContributor<Researcher> {

	@Override
	public void contribute(Document document, Researcher researcher) {
		try {
			document.addDate(Field.CREATE_DATE, researcher.getCreateDate());
			document.addDate(Field.MODIFIED_DATE, researcher.getModifiedDate());
			
			Company company = CompanyLocalServiceUtil.fetchCompany(researcher.getCompanyId());
			Locale defaultLocale = PortalUtil.getSiteDefaultLocale(company.getGroupId());
						
			document.addText(ECRFUserResearcherAttributes.NAME, researcher.getName());
			document.addText(ECRFUserResearcherAttributes.EMAIL, researcher.getEmail());
			document.addDate(ECRFUserResearcherAttributes.BIRTH, researcher.getBirth());
			document.addText(ECRFUserResearcherAttributes.INSTITUTION, researcher.getInstitution());
			
			long userId = researcher.getResearcherUserId();
			User user = null;
			if(userId > 0) {
				user = _userLocalService.getUser(userId);
			}
			
			if(Validator.isNotNull(user)) {
				document.addText(ECRFUserResearcherAttributes.SCREEN_NAME, user.getScreenName());
			} else {
				_log.info("user is null");
			}
		} catch(PortalException e) {
			if(_log.isWarnEnabled()) {
				_log.warn("Unable to index researcher " + researcher.getResearcherId(), e);
			}
		}
	}
	
	private static final Log _log = LogFactoryUtil.getLog(ResearcherModelDocumentContributor.class);
	
	@Reference
	private UserLocalService _userLocalService;
}