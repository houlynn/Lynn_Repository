package org.yingqu.baoli.ebo;
import java.util.Set;

import org.yingqu.baoli.model.Interact;
import org.yingqu.baoli.model.Photograph;
import org.yingqu.baoli.ebi.InteractEbi;
import org.yingqu.framework.ebo.SimpleEbo;
import org.springframework.stereotype.Service;

@Service
public class InteractEbo extends SimpleEbo<Interact> implements InteractEbi {

protected InteractEbo()  {
		super(Interact.class);
	}
public void saveInteract(Interact model)throws Exception{
	   Set<Photograph> imgs= model.getPhotourl();
	   repertory.save(model);
	   for(Photograph img : imgs){
		   img.setIt(model);
		   repertory.save(img);
	   }
}


}
