package _a.model;

import _h.model.HomelessBean;


public class JoinBean {
	private ArticleBean aBean;
	private HomelessBean hBean;
	
	public JoinBean() {
	}
	
	public JoinBean(ArticleBean aBean, HomelessBean hBean) {
		this.aBean = aBean;
		this.hBean = hBean;
	}

	public ArticleBean getaBean() {
		return aBean;
	}

	public void setaBean(ArticleBean aBean) {
		this.aBean = aBean;
	}

	public HomelessBean gethBean() {
		return hBean;
	}

	public void sethBean(HomelessBean hBean) {
		this.hBean = hBean;
	}
}
