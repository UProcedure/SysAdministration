package com.qf.oa.vo;

public class SysMenuVo {
    private Long menuId;

    private Long menuParentId;

    private String menuName;

    private boolean open = true;

    private boolean checked;

    @Override
    public String toString() {
        return "SysMenuVo{" +
                "menuId=" + menuId +
                ", menuParentId=" + menuParentId +
                ", menuName='" + menuName + '\'' +
                ", open=" + open +
                ", checked=" + checked +
                '}';
    }

    public Long getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Long menuParentId) {
        this.menuParentId = menuParentId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
