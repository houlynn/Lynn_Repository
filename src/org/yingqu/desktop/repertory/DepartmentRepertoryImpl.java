package org.yingqu.desktop.repertory;

import org.yingqu.desktop.irepertory.DepartmentRepertory;
import org.yingqu.desktop.model.Department;
import org.yingqu.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepertoryImpl extends SimpleRepertoryHibernateImpl<Department>  implements DepartmentRepertory{

	protected DepartmentRepertoryImpl() {
		super(Department.class);
	}

}
