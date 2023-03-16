package ecrf.user.search.researcher;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.Localization;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import java.util.Locale;

import org.osgi.service.component.annotations.Component;

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
			
			Locale defaultLocale = PortalUtil.getSiteDefaultLocale(researcher.getGroupId());
			
			document.addText(ECRFUserResearcherAttributes.NAME, researcher.getName());
		} catch(PortalException e) {
			if(_log.isWarnEnabled()) {
				_log.warn("Unable to index researcher " + researcher.getResearcherId(), e);
			}
		}
		
	}
	
	private static final Log _log = LogFactoryUtil.getLog(ResearcherModelDocumentContributor.class);

}
