package ecrf.user.constants;

public class ECRFUserMVCCommand {
	public static final String RENDER_LOGIN_CREATE_ACCOUNT = "/login/create_account";
	public static final String RENDER_USERS_ADMIN_EDIT_USER = "/users_admin/edit_user";
	
	public static final String ACTION_MOVE_OTHER_PAGE = "/action/redirect/other-page";
	
	
	public static final String ACTION_ADD_RESEARCHER = "/action/researcher/add-researcher";
	public static final String ACTION_UPDATE_RESEARCHER = "/action/researcher/update-researcher";
	public static final String ACTION_DELETE_RESEARCHER = "/action/researcher/delete-researcher";
	public static final String RENDER_VIEW_RESEARCHER = "/render/researcher/view-researcher";
	public static final String RENDER_LIST_RESEARCHER = "/render/researcher/list-researcher";
	public static final String RENDER_UPDATE_RESEARCHER = "/render/researcher/update-researcher";
	public static final String RENDER_ADD_RESEARCHER = "/render/researcher/add-researcher";
	
	
	public static final String RENDER_VIEW_PROJECT = "/render/project/view-project";
	public static final String RENDER_ADD_PROJECT = "/render/project/add-project";
	public static final String RENDER_UPDATE_PROJECT = "/render/project/update-project";
	public static final String ACTION_ADD_PROJECT = "/action/project/add-project";
	public static final String ACTION_UPDATE_PROJECT = "/action/project/update-project";
	public static final String ACTION_DELETE_PROJECT = "/action/project/delete-project";
	
	
	public static final String RENDER_VIEW_MEMBERSHIP = "/render/approve/view-membership";
	public static final String RENDER_APPROVE_MEMBERSHIP = "/render/approve/approve-membership";
	public static final String ACTION_REVIEW_MEMBERSHIP_REQUEST = "/action/approve/review-membership-request";
	public static final String ACTION_APPROVE_MEMBERSHIP = "/action/approve/approve-membership";
	public static final String ACTION_REJECT_MEMBERSHIP = "/action/approve/reject-membership";
	
	
	public static final String RENDER_VIEW_SITE = "/render/main/view-site";
	public static final String RENDER_REQUEST_MEMBERSHIP = "/render/main/request-membership";
	public static final String ACTION_REQUEST_MEMBERSHIP = "/action/main/request-membership";
	public static final String ACTION_ADD_MEMBERSHIP_REQUEST = "/action/main/add-membership-request";
	
	public static final String RENDER_VIEW_SUBJECT = "/render/subject/view-subject";
	public static final String RENDER_ADD_SUBJECT = "/render/subject/add-subject";
	public static final String RENDER_UPDATE_SUBJECT = "/render/subject/update-subject";
	public static final String RENDER_LIST_SUBJECT = "/render/subject/list-subject";
	
	public static final String ACTION_ADD_SUBJECT = "/action/subject/add-subject";
	public static final String ACTION_UPDATE_SUBJECT = "/action/subject/update-subject";
	public static final String ACTION_DELETE_SUBJECT = "/action/subject/delete-subject";
	
	public static final String ACTION_ADD_SUBJECTS_FILE = "/action/subject/add-subjects-file";
	public static final String RENDER_DEBUG_PAGE = "/render/debug-page";
	
	
	public static final String RENDER_VIEW_CRF = "/render/crf/view-crf";
	public static final String RENDER_ADD_CRF = "/render/crf/add-crf";
	public static final String RENDER_UPDATE_CRF = "/render/crf/update-crf";
	public static final String RENDER_LIST_CRF = "/render/crf/list-crf";
	
	public static final String ACTION_ADD_CRF = "/action/crf/add-crf";
	public static final String ACTION_UPDATE_CRF = "/action/crf/update-crf";
	public static final String ACTION_DELETE_CRF = "/action/crf/delete-crf";
	
	public static final String ACTION_MOVE_CRF = "/action/crf/move-crf";
	public static final String ACTION_MOVE_CRF_FORM = "/action/crf/move-crf-form";
	public static final String ACTION_MOVE_CRF_DATA = "/action/crf/move-crf-data";
	public static final String ACTION_MOVE_CRF_QUERY = "/action/crf/move-crf-query";
	public static final String ACTION_MOVE_CRF_META = "/action/crf/move-crf-meta";
	
	public static final String RENDER_LIST_CRF_DATA = "/render/crf-data/list-crf-data";
	public static final String RENDER_UPDATE_CRF_DATA = "/render/crf-data/update-crf-data";
	public static final String RENDER_VIEW_CRF_DATA = "/render/crf-data/view-crf-data";
	
	public static final String ACTION_ADD_CRF_DATA = "/action/crf-data/add-crf-data";
	public static final String ACTION_UPDATE_CRF_DATA = "/action/crf-data/update-crf-data";
	public static final String ACTION_DELETE_CRF_DATA = "/action/crf-data/delete-crf-data";
	public static final String ACTION_DELETE_ALL_CRF_DATA = "/action/crf-data/delete-all-crf-data";
	
	public static final String ACTION_CHANGE_UPDATE_LOCK= "/action/crf-data/change-update-lock";
	
	public static final String RENDER_VIEW_AUDIT = "/render/crf-data/view-audit";
	
	public static final String RENDER_DIALOG_AUDIT = "/render/crf-data/dialog-audit";
	
	public static final String RENDER_DIALOG_CRF = "/render/crf-data/crf-data-selector";
	public static final String RENDER_DIALOG_HISTORY = "/render/crf-data/dialog-history";
	public static final String RENDER_DIALOG_CRF_DATA_GRAPH = "/render/crf-data/dialog-graph";
	
	public static final String ACTION_SEARCH_CRF_DATA_HISTORY = "/action/crf-data/search-history";
	public static final String RENDER_LIST_CRF_DATA_HISTORY = "/render/crf-data/list-history";
	public static final String RENDER_VIEW_CRF_DATA_HISTORY = "/render/crf-data/view-history";
	
	public static final String ACTION_DELETE_ALL_CRF_HISTORY = "/action/crf-data/delete-all-history";
	
	public static final String RENDER_CRF_DATA_EXCEL_DOWNLOAD = "/render/crf-data/excel-download";
	public static final String RENDER_SEARCH_CRF_DATA = "/render/crf-data/search-crf-data";
	public static final String ACTION_REDIRECT_EXCEL_DOWNLOAD = "/action/crf-data/excel-redirect";
	
	public static final String RENDER_LIST_CRF_QUERY = "/render/crf-query/query-list";
	public static final String RENDER_UPDATE_CRF_QUERY = "/render/crf-query/query-edit";
	
	public static final String ACTION_DELETE_CRF_QUERY = "/action/crf-query/query-delete";
	public static final String ACTION_DELETE_ALL_CRF_QUERY = "/action/crf-query/query-delete-all";
	public static final String ACTION_COMFIRM_CRF_QUERY = "/action/crf-query/query-comfirm";
	public static final String ACTION_REFUSE_CRF_QUERY = "/action/crf-query/query-refuse";
	public static final String ACTION_ALL_CRF_QUERY = "/action/crf-query/query-all";
	
	public static final String ACTION_REDIRECT_CRF_QUERY = "/action/crf/redirect-crf-query";
	public static final String ACTION_REDIRECT_UPDATE_CRF_QUERY = "/action/crf/redirect-update-crf-query";
	
	public static final String RENDER_MANAGE_FORM = "/render/crf-form/manage-form";
	public static final String RENDER_CRF_FORM_PDF_DOWNLOAD = "/render/crf-form/pdf-download";
	
}