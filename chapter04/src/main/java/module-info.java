/**
 * Created by iuliana.cosmina on 12/02/2021.
 */
module chapter.four {
    requires chapter.zero;
    //requires transitive java.logging;
    exports com.apress.bgn.four.classes;
    exports com.apress.bgn.four.hierarchy;

    requires org.apache.commons.lang3;
}