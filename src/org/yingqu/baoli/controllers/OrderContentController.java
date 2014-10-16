package org.yingqu.baoli.controllers;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;






import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import org.yingqu.baoli.model.Goods;
import org.yingqu.baoli.model.OrderContent;
import org.yingqu.baoli.model.OrderItem;
import org.yingqu.baoli.model.OrderView;
import org.yingqu.baoli.model.UserAdress;
import org.yingqu.framework.controllers.SimpleBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/bl/order")
@Controller
public class OrderContentController extends SimpleBaseController<OrderContent> {

	protected OrderContentController() {
		super(OrderContent.class);
	}

	@Override
	public OrderContent getModel(HttpServletRequest request, OrderContent model) {
		return model;
	}

	@Override
	public void load(HttpServletRequest request, HttpServletResponse response) {
		try {
			StringBuffer hql = new StringBuffer("from " + clazz.getSimpleName()
					+ " where 1=1");
			StringBuffer countHql = new StringBuffer("select count(*) from "
					+ clazz.getSimpleName() + " where 1=1");
			String whereSql = request.getParameter("whereSql");
			whereSql = whereSql == null ? "" : whereSql;
			hql.append(whereSql);
			String parentSql = request.getParameter("parentSql");
			parentSql = parentSql == null ? "" : parentSql;
			hql.append(parentSql);
			String querySql = request.getParameter("querySql");
			querySql = querySql == null ? "" : querySql;
			hql.append(querySql);
			String orderSql = request.getParameter("orderSql");
			orderSql = orderSql == null ? " order by ordertime" : orderSql;
			int start = 0;
			int limit = 30;
			String startStr = request.getParameter("start");
			start = startStr == null ? 0 : Integer.valueOf(startStr);
			String limitStr = request.getParameter("limit");
			countHql.append(whereSql);
			countHql.append(querySql);
			countHql.append(parentSql);
			Integer count = ebi.getCount(countHql.toString());
			limit = limitStr == null ? limit : Integer.valueOf(limitStr);
			hql.append(orderSql);
			List<OrderContent> lists = (List<OrderContent>) ebi.queryByHql(hql.toString(), start, limit);
			List<OrderView> views=lists.parallelStream().map(item->{
				OrderView view=new OrderView();
				view.setAcount(item.getAcount());
				view.setOrdid(item.getOrdid());
				view.setOrdertime(item.getOrdertime());
				view.setLoginCode(item.getLoginCode());
				view.setOrdertime(item.getOrdertime());
				view.setIspay(item.getIspay());
				view.setWeekendto(item.getWeekendto());
				view.setPayType(item.getPayType());
				try {
					UserAdress adress=(UserAdress) ebi.findById(UserAdress.class, item.getAdressid());
					if(adress!=null){
						view.setAddress(adress.getAddress());
						view.setPostcode(adress.getPostcode());
						view.setUname(adress.getUname());
						view.setPhone(adress.getPhone());
				Set<OrderItem> items=item.getItems();
				if(items!=null&&items.size()>0){
					OrderItem order=items.iterator().next();
					view.setCount(order.getCount());
					view.setPrice(order.getPrice());
					  Goods goods=(Goods) ebi.findById(Goods.class, order.getGid());
					  if(goods!=null){
						  view.setGdName(goods.getName());
					  }
				}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return view;
			}).collect(Collectors.toList());
			String strData = jsonBuilder.buildObjListToJson(new Long(count),
					views, true);
			toWrite(response, strData);
		} catch (Exception e) {
			e.printStackTrace();
			error("加载数据失败！", e);
		}
	}

}
