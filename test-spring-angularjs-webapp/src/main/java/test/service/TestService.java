package test.service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;

import test.utils.info.TestInfo;

@Service
public class TestService {

    private LinkedHashMap<Long, TestInfo> list = new LinkedHashMap<Long, TestInfo>();

    public TestService() {
        TestInfo info = new TestInfo(0, "Name 0", new Date(), new BigDecimal("0.00"));
        list.put(info.getId(), info);
        info = new TestInfo(1, "Name 1", new Date(), new BigDecimal("1.00"));
        list.put(info.getId(), info);
        info = new TestInfo(2, "Name 2", new Date(), new BigDecimal("2.00"));
        list.put(info.getId(), info);
        info = new TestInfo(3, "Name 3", new Date(), new BigDecimal("3.00"));
        list.put(info.getId(), info);
        info = new TestInfo(4, "Name 4", new Date(), new BigDecimal("4.00"));
        list.put(info.getId(), info);
        info = new TestInfo(5, "Name 5", new Date(), new BigDecimal("5.00"));
        list.put(info.getId(), info);
        info = new TestInfo(6, "Name 6", new Date(), new BigDecimal("6.00"));
        list.put(info.getId(), info);
        info = new TestInfo(7, "Name 7", new Date(), new BigDecimal("7.00"));
        list.put(info.getId(), info);
        info = new TestInfo(8, "Name 8", new Date(), new BigDecimal("8.00"));
        list.put(info.getId(), info);
        info = new TestInfo(9, "Name 9", new Date(), new BigDecimal("9.00"));
        list.put(info.getId(), info);
    }

    public Collection<TestInfo> getAll() {
        return list.values();
    }

    public TestInfo get(Long id) {
        return list.get(id);
    }

    public boolean create(TestInfo info) {
        if (list.get(info.getId()) != null) {
            return false;
        }
        list.put(info.getId(), info);
        return true;
    }

    public boolean update(TestInfo info) {
        if (list.get(info.getId()) != null) {
            list.put(info.getId(), info);
            return true;
        }
        return false;
    }

    public boolean delete(Long id) {
        return list.remove(id) != null;
    }
}
