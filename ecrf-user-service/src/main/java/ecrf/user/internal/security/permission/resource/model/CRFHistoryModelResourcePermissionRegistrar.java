/**
 * 
 */
package ecrf.user.internal.security.permission.resource.model;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.StagedModelPermissionLogic;
import com.liferay.portal.kernel.security.permission.resource.WorkflowedModelPermissionLogic;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.HashMapDictionary;
import com.liferay.portal.kernel.workflow.permission.WorkflowPermission;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.constants.ECRFUserConstants;
import ecrf.user.constants.ECRFUserPortletKeys;
import ecrf.user.model.CRFHistory;
import ecrf.user.service.CRFHistoryLocalService;

/**
 * @author SELab-Ryu
 *
 */

@Component( immediate = true )
public class CRFHistoryModelResourcePermissionRegistrar {
	@Activate
	public void activate(BundleContext bundleContext) {
		Dictionary<String, Object> properties = new HashMapDictionary<>();
        properties.put("model.class.name", CRFHistory.class.getName());
        
        _serviceRegistration = bundleContext.registerService(
    		ModelResourcePermission.class,
    		ModelResourcePermissionFactory.create(
				CRFHistory.class, 
				CRFHistory::getHistoryId,
				_crfHistoryLocalService::getCRFHistory,
				_portletResourcePermission,
				(modelResourcePermission, consumer) -> {
					consumer.accept(
						new WorkflowedModelPermissionLogic<>(
							_workflowPermission,
							modelResourcePermission,
							_groupLocalService,
							CRFHistory::getHistoryId
						)
					);
					consumer.accept(
						new StagedModelPermissionLogic<>(
							_stagingPermission,
							ECRFUserPortletKeys.CRF,
							CRFHistory::getHistoryId)
					);
				}
			),
    		properties
		);
	}
	
	@Deactivate
	public void deactivate() {
		_serviceRegistration.unregister();
	}
	
	@Reference
    private CRFHistoryLocalService _crfHistoryLocalService;

    @Reference(target = "(resource.name=" + ECRFUserConstants.RESOURCE_NAME + ")")
    private PortletResourcePermission _portletResourcePermission;

    private ServiceRegistration<ModelResourcePermission> _serviceRegistration;

    @Reference
    private StagingPermission _stagingPermission;

    @Reference
    private WorkflowPermission _workflowPermission;

    @Reference
    private GroupLocalService _groupLocalService;
}
