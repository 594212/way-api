//package com.concretepage
//
//import com.example.way.api.data.models.Chapter
//import com.example.way.api.data.models.Manga
//import com.example.way.api.data.models.MediaGhost
//import com.example.way.api.data.models.MediaGhostModel
//import org.hibernate.Session
//import org.hibernate.SessionFactory
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder
//import org.hibernate.cfg.Configuration
//
//
//object Test {
//    @JvmStatic
//    fun main(args: Array<String>) {
//        val session: Session = HibernateUtil.getSessionFactory()!!.openSession()
//        session.beginTransaction()
//
//        val manga = Manga(name = "Manga_1")
//        session.persist(manga)
//        val chapter = Chapter(chapter = 5, manga = manga)
//        session.persist(chapter)
//        val model = ArrayList<MediaGhostModel>()
//        model.addAll(arrayOf(manga,chapter))
//        val MediaGhost = MediaGhost(id = 1,model = model)
//
//        session.persist(MediaGhost);
//
//        session.getTransaction().commit();
//
//
//
//
//        val mediaProj: MediaGhost = session[MediaGhost::class.java, 1] as MediaGhost
//        for (md in mediaProj.model!!) {
//            println("model: ${md.id}")
//        }
//
//        session.close();
//        HibernateUtil.closeSessionFactory();
//    }
//}
//
//object HibernateUtil {
//    private var sessionFactory: SessionFactory? = null
//    fun getSessionFactory(): SessionFactory? {
//        return sessionFactory
//    }
//
//    fun closeSessionFactory() {
//        sessionFactory?.close()
//    }
//
//    init {
//        val configuration: Configuration = Configuration().configure()
//        val builder = StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
//        sessionFactory = configuration.buildSessionFactory(builder.build())
//    }
//}