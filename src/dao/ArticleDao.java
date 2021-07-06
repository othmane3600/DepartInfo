package dao;


import metierEntite.Articles;

public interface ArticleDao {
	
	public Articles Add(Articles a);
	public void Modify(Articles a);
	public void Delete(Articles a);
}
