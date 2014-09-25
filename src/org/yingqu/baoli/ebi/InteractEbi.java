package org.yingqu.baoli.ebi;
import org.yingqu.baoli.model.Interact;
import org.yingqu.framework.ebi.SimpleEbi;

public interface InteractEbi extends SimpleEbi<Interact> {
	public void saveInteract(Interact model)throws Exception;
}
