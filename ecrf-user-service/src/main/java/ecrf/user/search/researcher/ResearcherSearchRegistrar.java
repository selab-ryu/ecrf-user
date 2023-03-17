package ecrf.user.search.researcher;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import ecrf.user.model.Researcher;

@Component (immediate=true, service = {})
public class ResearcherSearchRegistrar {
	@Activate
	protected void activate(BundleContext bundleContext) {
		System.out.println("===== Begin " + this.getClass().getName()  + " activator() =====");
		System.out.println("_serviceRegistration: "+ Validator.isNotNull(_serviceRegistration));
		System.out.println("_modelSearchRegistrarHelper: "+ Validator.isNotNull(modelSearchRegistrarHelper));
		System.out.println("_modelIndexWriterContributor: "+ Validator.isNotNull(modelIndexWriterContributor));
		System.out.println("_modelSummaryContributor: "+ Validator.isNotNull(modelSummaryContributor));
		
		_serviceRegistration = modelSearchRegistrarHelper.register(
				Researcher.class, bundleContext, 
				modelSearchDefinition -> {
					modelSearchDefinition.setDefaultSelectedFieldNames(
						Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT,
						Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK,
						Field.GROUP_ID, Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID,
	                    Field.TITLE, Field.UID);
					modelSearchDefinition.setModelIndexWriteContributor(
	                    modelIndexWriterContributor);
	                modelSearchDefinition.setModelSummaryContributor(
	                    modelSummaryContributor);
				}
		);
	}
	
	@Deactivate
    protected void deactivate() {
        _serviceRegistration.unregister();
    }
	
	@Reference(target = "(indexer.class.name=ecrf.user.model.Researcher)")
    protected ModelIndexerWriterContributor<Researcher> modelIndexWriterContributor;

    @Reference
    protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

    @Reference(target = "(indexer.class.name=ecrf.user.model.Researcher)")
    protected ModelSummaryContributor modelSummaryContributor;

    private ServiceRegistration<?> _serviceRegistration;
}
