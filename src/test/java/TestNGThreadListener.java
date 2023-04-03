import org.testng.*;

import java.util.*;
public class TestNGThreadListener implements IInvokedMethodListener {
    private Map<Long, List<String>> threadClassesMap = new HashMap<>();

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // Получаем идентификатор текущего потока
        long threadId = Thread.currentThread().getId();

        // Получаем список классов, выполняющихся на текущем потоке
        List<String> threadClasses = threadClassesMap.get(threadId);
        if (threadClasses == null) {
            threadClasses = new ArrayList<>();
        }

        // Добавляем имя класса к списку
        threadClasses.add(method.getTestMethod().getTestClass().getName());

        // Сохраняем список классов для текущего потока
        threadClassesMap.put(threadId, threadClasses);
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // Ничего не делаем
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        // Ничего не делаем
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        // Ничего не делаем
    }

    public void printThreadClasses() {
        // Выводим информацию о классах, выполняющихся на каждом потоке
        for (Map.Entry<Long, List<String>> entry : threadClassesMap.entrySet()) {
            System.out.println("TestListenerInfo: Thread ID: " + entry.getKey() + ", Classes: " + entry.getValue());
        }
    }
}
