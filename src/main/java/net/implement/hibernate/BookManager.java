package net.implement.hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
public class BookManager {
	protected SessionFactory sessionFactory;
	 
    protected void setup() {
        // code to load Hibernate Session factory
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure() // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    		ex.printStackTrace();
    	    StandardServiceRegistryBuilder.destroy(registry);
    	}
    }
 
    protected void exit() {
        // code to close Hibernate Session factory
    	
    	sessionFactory.close();
    	
    }
 
    protected void create() {
        // code to save a book
    	Book book=new Book();
    	Book book2=new Book();
    	book.setId(45);
    	book.setTitle("Effective Spring");
    	book.setAuthor("Jason Guild");
    	book.setPrice(56.05f);
    	book2.setId(23);
    	book2.setTitle("Spring boot");
    	book2.setAuthor("Ajay Mehul");
    	book2.setPrice(345.09f);
    	Session session=sessionFactory.openSession();
    	session.beginTransaction();
    	session.save(book);
    	session.save(book2);
    	session.getTransaction().commit();
    	session.close();
    }
 
    protected void read() {
        // code to get a book
    }
 
    protected void update() {
        // code to modify a book
    }
 
    protected void delete() {
        // code to remove a book
    }
	public static void main(String[] args) {
		BookManager manager=new BookManager();
		manager.setup();
		manager.create();
		manager.exit();

	}

}
