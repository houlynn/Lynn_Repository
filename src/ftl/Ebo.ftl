package org.HouLynn.desktop.ebo;


import org.HouLynn.desktop.ebi.${className}Ebi;
import org.HouLynn.desktop.model.${className};
import org.HouLynn.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class ${className}Ebo extends SimpleEbo<${className}> implements ${className}Ebi {

	protected ${className}Ebo() {
		super(${className}.class);
		// TODO Auto-generated constructor stub
	}

}
