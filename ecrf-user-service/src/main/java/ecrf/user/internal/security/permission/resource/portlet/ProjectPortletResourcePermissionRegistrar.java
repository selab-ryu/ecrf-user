package ecrf.user.internal.security.permission.resource.portlet;

import com.liferay.exportimport.kernel.staging.permission.StagingPermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.StagedPortletPermissionLogic;
import com.liferay.portal.kernel.util.HashMapDictionary;

import java.util.Dictionary;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.constants.ECRFUserConstants;
import ecrf.user.constants.ECRFUserPortletKeys;

@Component (immediate = true)
public class ProjectPortletResourcePermissionRegistrar {
	@Activate
    public void activate(BundleContext bundleContext) {
        Dictionary<String, Object> properties = new HashMapDictionary<>();

        properties.put("resource.name", ECRFUserConstants.RESOURCE_NAME);

        _serviceRegistration = bundleContext.registerService(
            PortletResourcePermission.class,
            PortletResourcePermissionFactory.create(
        		ECRFUserConstants.RESOURCE_NAME,
                new StagedPortletPermissionLogic(
                    _stagingPermission, ECRFUserPortletKeys.PROJECT)
            ),
        	properties);
    }

    @Deactivate
    public void deactivate() {
        _serviceRegistration.unregister();
    }

    private ServiceRegistration<PortletResourcePermission> _serviceRegistration;

    @Reference
    private StagingPermission _stagingPermission;
}
