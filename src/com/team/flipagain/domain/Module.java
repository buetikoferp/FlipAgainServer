package com.team.flipagain.domain;

import java.io.Serializable;

/**
 * Created by Raffaele on 23.03.2016.
 */
public class Module implements Serializable{
    /**
	 * 
	 */

	//ATTRIBUT
    private int moduleId;
    private String moduleName;

    public Module(int moduleId, String moduleName){
        this.moduleId = moduleId;
        this.moduleName = moduleName;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
