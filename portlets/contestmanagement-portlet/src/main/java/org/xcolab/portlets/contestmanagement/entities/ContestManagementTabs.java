package org.xcolab.portlets.contestmanagement.entities;

import org.xcolab.interfaces.*;

import javax.portlet.PortletRequest;

/**
 * Created by Thomas on 2/9/2015.
 */
public enum ContestManagementTabs implements TabEnum{
		OVERVIEW("Contests overview", TabPermissionAlgorithm.contestCreationViewAndEdit, TabActivityCountAlgorithm.alwaysZero),
	//PHASES("Phase types", TabPermissionAlgorithm.contestCreationViewAndEdit, TabActivityCountAlgorithm.alwaysZero),
	SCHEDULES("Schedules", TabPermissionAlgorithm.adminOnlyViewAndEdit, TabActivityCountAlgorithm.alwaysZero);
	//PROPOSALTEMPLATES("Proposal Templates", TabPermissionAlgorithm.contestCreationViewAndEdit, TabActivityCountAlgorithm.alwaysZero);

	private final String displayName;
	private final TabPermissionAlgorithm tabPermissionAlgorithm;
	private final TabActivityCountAlgorithm activitiesCountAlgorithm;

	private ContestManagementTabs(String displayName, TabPermissionAlgorithm tabPermissionAlgorithm,
								  TabActivityCountAlgorithm activitiesCountAlgorithm) {
		this.displayName = displayName;
		this.tabPermissionAlgorithm = tabPermissionAlgorithm;
		this.activitiesCountAlgorithm = activitiesCountAlgorithm;
	}

	public String getDisplayName() {
		return displayName;
	}

	public String getName() {
		return this.name();
	}

	public boolean getIsDefault() {
		return this.ordinal() == 0;
	}

	public boolean getCanView(TabPermissions permissions, TabContext context, PortletRequest request) {
		return tabPermissionAlgorithm.canView(permissions, context, request);
	}

	public boolean getCanEdit(TabPermissions permissions, TabContext context, PortletRequest request) {
		return tabPermissionAlgorithm.canEdit(permissions, context, request);
	}

	public boolean getCanAddComment(TabPermissions permissions, TabContext context, PortletRequest request){
		return tabPermissionAlgorithm.getCanAddComment(permissions, context, request);
	}

	public int getActivityCount(TabContext context, PortletRequest request){
		return activitiesCountAlgorithm.getActivityCount(context, request);
	}

}
