package design.clean_up_resources;

@FunctionalInterface
public interface UseInstance<T, X extends Throwable> {
    void use(T instance) throws X;
}
