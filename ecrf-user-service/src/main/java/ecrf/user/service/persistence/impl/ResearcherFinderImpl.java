/**
 * 
 */
package ecrf.user.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import ecrf.user.model.Researcher;
import ecrf.user.service.ResearcherLocalServiceUtil;
import ecrf.user.service.persistence.ResearcherFinder;

/**
 * @author SELab-Ryu
 *
 */
@Component(service = ResearcherFinder.class)
public class ResearcherFinderImpl extends ResearcherFinderBaseImpl implements ResearcherFinder {
	public List<Researcher> findByUserIds(long[] userIds) {
		Session session = null;
		List<Researcher> resultList = new ArrayList<>();
		
		// parameter check
		if(Validator.isNotNull(userIds)) {
			try {
				session = openSession();
				ClassLoader classLoader = getClass().getClassLoader();
				DynamicQuery researcherQuery = DynamicQueryFactoryUtil.forClass(Researcher.class, "researcher", classLoader);
				
				if(Validator.isNotNull(userIds) && userIds.length > 0) {
					researcherQuery.add(PropertyFactoryUtil.forName("researcherUserId").in(userIds));
				}
				
				resultList = ResearcherLocalServiceUtil.dynamicQuery(researcherQuery);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeSession(session);
			}
		}
		
		return resultList;
	}
}
