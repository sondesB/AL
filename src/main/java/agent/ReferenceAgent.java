package agent;

import java.util.UUID;

public class ReferenceAgent {
    private final UUID referenceInterne;

    public ReferenceAgent() {
        referenceInterne = UUID.randomUUID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ReferenceAgent that = (ReferenceAgent) o;

        return referenceInterne.equals(that.referenceInterne);
    }

    @Override
    public int hashCode() {
        return referenceInterne.hashCode();
    }
}
