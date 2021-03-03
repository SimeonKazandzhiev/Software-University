package aquarium.repositories;

import aquarium.models.decorations.contracts.Decoration;

public interface Repository  {
    void add(Decoration decoration);

    boolean remove(Decoration decoration);

    Decoration findByType(String type);
}
