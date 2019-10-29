package org.hystudio.httpframework;

public interface IRequestResolvableSession {
    void executeRequestDataResolver();

    void executeResponseDataResolver();
}
