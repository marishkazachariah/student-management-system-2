package org.startsteps.model.crud;

import org.startsteps.annotations.MethodMetadata;

public interface CRUD<T> {
    @MethodMetadata(description = "This method adds an object of any type to a list of objects of any type.")
    void add(T item);

    @MethodMetadata(description = "This method edits an object of any type in a list of objects of any type.")
    void edit(int id);

    @MethodMetadata(description = "This method deletes an object of any type from a list of objects of any type.")
    void delete(T item);

    @MethodMetadata(description = "This method displays records of any type.")
    void displayRecords();
}