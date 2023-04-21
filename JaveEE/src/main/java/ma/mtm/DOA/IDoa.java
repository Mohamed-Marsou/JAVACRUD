package ma.mtm.DOA;

import java.util.List;

public interface IDoa<T> {
    boolean create(T o);
    boolean delete (int id);
    boolean update (T o,int id);
    T findById(int id);
    List<T> findAll();
}
