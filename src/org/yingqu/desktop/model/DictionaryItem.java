package org.yingqu.desktop.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.yingqu.framework.annotation.FieldInfo;
import org.yingqu.framework.annotation.NodeType;
import org.yingqu.framework.constant.ExtFieldType;
import org.yingqu.framework.constant.TreeNodeType;
import org.yingqu.framework.model.TreeBaseEntity;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@GenericGenerator(name="systemUUID",strategy="uuid")
public class DictionaryItem extends TreeBaseEntity{
	@NodeType(type=TreeNodeType.ID)
	@FieldInfo(name="主键",type=ExtFieldType.ID)
	private String itemId;
	@NodeType(type=TreeNodeType.TEXT)
	@FieldInfo(name="项名称")
	private String itemName;
	@NodeType(type=TreeNodeType.CODE)
	@FieldInfo(name="项编码")
	private String itemCode;
	@NodeType(type=TreeNodeType.PARENT)
	private DictionaryItem parent;
	private Set<DictionaryItem> children=new HashSet<DictionaryItem>();
	private Dictionary dictionary;
	@Id
	@GeneratedValue(generator="systemUUID")
	@Column(length=50)
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	@ManyToOne
    @JoinColumn(name="PARENT")
	public DictionaryItem getParent() {
		return parent;
	}
	public void setParent(DictionaryItem parent) {
		this.parent = parent;
	}
	@JsonIgnore
	@OneToMany(mappedBy="parent",cascade={CascadeType.REMOVE},fetch=FetchType.LAZY)
    @LazyCollection(LazyCollectionOption.TRUE)
	public Set<DictionaryItem> getChildren() {
		return children;
	}
	public void setChildren(Set<DictionaryItem> children) {
		this.children = children;
	}
	@JsonIgnore
    @ManyToOne(optional=false)
    @JoinColumn(name="DDId")
	public Dictionary getDictionary() {
		return dictionary;
	}
	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}
	@Transient
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "数字字典子条目";
	}
	
	
}
