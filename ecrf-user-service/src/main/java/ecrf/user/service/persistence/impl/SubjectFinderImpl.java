package ecrf.user.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import ecrf.user.model.Subject;
import ecrf.user.service.SubjectLocalServiceUtil;
import ecrf.user.service.persistence.SubjectFinder;

@Component(service = SubjectFinder.class)
public class SubjectFinderImpl extends SubjectFinderBaseImpl implements SubjectFinder{
	public List<Subject> findBySubjectIds(long groupId, long[] subjectIds) {
		Session session = null;
		
		List<Subject> resultList = new ArrayList<Subject>();

		// parameter check
		if(groupId > 0 && Validator.isNotNull(subjectIds)) {
			try {
				session = openSession();
				
				ClassLoader classLoader = getClass().getClassLoader();
				
				DynamicQuery subjectQuery = DynamicQueryFactoryUtil.forClass(Subject.class, "subject", classLoader);
				
				if(Validator.isNotNull(groupId) && groupId > 0) {
					subjectQuery.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
				}
				

				if(Validator.isNotNull(subjectIds) && subjectIds.length > 0) {
					subjectQuery.add(PropertyFactoryUtil.forName("subjectId").in(subjectIds));
				}
				
				resultList = SubjectLocalServiceUtil.dynamicQuery(subjectQuery); 
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeSession(session);
			}
		}
	
		return resultList;
	}	
}
