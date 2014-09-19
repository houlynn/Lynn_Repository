import org.yingqu.desktop.ebi.OperateLogEbi;
import org.yingqu.desktop.model.EndUser;
import org.yingqu.desktop.model.OperateLog;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class TestModel {

	private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-*.*");
	public static void main(String[] args) throws Exception {
		
		BeanFactory factory = (BeanFactory) context;
		OperateLogEbi	ebi=(OperateLogEbi) factory.getBean("operateLogEbo");
	    ebi.save(new OperateLog());
	   // Hibernate: insert into OperateLog
	}
}
