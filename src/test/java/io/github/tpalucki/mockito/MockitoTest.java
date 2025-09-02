package io.github.tpalucki.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MockitoTest {

    class A {
        int doSth() {
            return -1;
        }

        int returnTheSame(int arg) {
            return arg;
        }
    }

    @Test
    void mockTest() {
        A a = Mockito.mock(A.class);
        Mockito.when(a.doSth()).thenReturn(2);
        assertEquals(2, a.doSth());
    }

    /**
     * Verify w mockito służy do sprawdzenia czy dana metoda została wywołana z takim a takim parametrem albo określoną ilosć razy
     */
    @Test
    void verifyTest() {
        A a = Mockito.mock(A.class);

        a.doSth();
        a.returnTheSame(-2);
        a.returnTheSame(2);

        Mockito.verify(a).doSth();
        Mockito.verify(a, Mockito.atLeast(1)).returnTheSame(-2);
        Mockito.verify(a, Mockito.atLeastOnce()).returnTheSame(2);
    }

    @Test
    void a() {
        A a = Mockito.mock(A.class);

        Mockito.when(a.returnTheSame(Mockito.anyInt())).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> a.returnTheSame(1));
    }

    @Test
    void b() {
        var a = Mockito.mock(A.class);
        Mockito.when(a.returnTheSame(Mockito.anyInt())).thenReturn(1, 2, 3);

        assertEquals(1, a.returnTheSame(100));
        assertEquals(2, a.returnTheSame(100));
        assertEquals(3, a.returnTheSame(100));
        assertEquals(3, a.returnTheSame(100));
        assertEquals(3, a.returnTheSame(100));
    }

    /**
     * Spy vs Mock
     * Oba to wersje test doubles
     * W spy pracujemy na real obiekcie, defaultMethod nie na fejkowym
     */
    @Test
    void c() {
        A a = Mockito.spy(new A());

        Mockito.when(a.returnTheSame(1)).thenReturn(2);

        assertEquals(2, a.returnTheSame(1));
        assertEquals(3, a.returnTheSame(3));
    }

    /**
     * W mocku bazujemy na fejkowym obiekcie wiec jak wywolamy metode bez zdefiniowanego zachowania to zwroci null/0
     */
    @Test
    void d() {
        A a = Mockito.mock(A.class);

        Mockito.when(a.returnTheSame(1)).thenReturn(2);

        assertEquals(2, a.returnTheSame(1));
        assertEquals(0, a.returnTheSame(3));
    }


}
