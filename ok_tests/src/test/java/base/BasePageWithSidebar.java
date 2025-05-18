package base;

import pages.elements.SidebarElement;

public abstract class BasePageWithSidebar extends BasePage {
    protected SidebarElement sidebar = new SidebarElement();

    public SidebarElement getSidebar() {
        return sidebar;
    }
}
