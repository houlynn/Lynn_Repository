package org.yingqu.desktop.ebo;


import org.yingqu.desktop.ebi.DepartmentDDeEbi;
import org.yingqu.desktop.model.Department;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class DepartmentDDeEbo extends SimpleEbo<Department> implements DepartmentDDeEbi {

	protected DepartmentDDeEbo() {
		super(Department.class);
		// TODO Auto-generated constructor stub
	}


}
