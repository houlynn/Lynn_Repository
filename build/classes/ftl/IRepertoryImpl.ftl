package org.HouLynn.desktop.repertory;

import org.HouLynn.desktop.irepertory.${className}Repertory;
import org.HouLynn.desktop.model.${className};
import org.HouLynn.framework.repertory.SimpleRepertoryHibernateImpl;
import org.springframework.stereotype.Repository;

@Repository
public class ${className}RepertoryImpl extends SimpleRepertoryHibernateImpl<${className}>  implements ${className}Repertory{

	protected ${className}RepertoryImpl() {
		super( ${className}.class);
	}

}
