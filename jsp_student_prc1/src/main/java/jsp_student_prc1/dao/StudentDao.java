package jsp_student_prc1.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jsp_student_prc1.dto.Student;

public class StudentDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("akash").createEntityManager();
	}

	public Student saveStudent(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(student);
		entityTransaction.commit();
		return student;
	}

	public Student loginStudent(String email) {
		EntityManager entityManager = getEntityManager();

		Query query = entityManager.createQuery("select s from Student s where s.email=?1");
		query.setParameter(1, email);
		Student student = (Student) query.getSingleResult();
		return student;
	}

	public List<Student> getListofStudent() {
		EntityManager entityManager = getEntityManager();
		String querry = "select s from Student s";

		Query query = entityManager.createQuery(querry);

		List<Student> s_list = query.getResultList();
		return s_list;
	}
	
	public Student updateStudent(Student student) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();
		return student;
	}

	public boolean deleteStudent(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Student student = entityManager.find(Student.class, id);
		
		if (student != null) {
			entityTransaction.begin();
			entityManager.remove(student);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
	public Student getStudentbyId(int id) {
		return getEntityManager().find(Student.class, id);
	}
}
