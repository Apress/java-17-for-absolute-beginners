import com.apress.bgn.one.service.Provider;
import com.apress.bgn.zero.service.NakedService;

/**
 * Created by iuliana.cosmina on 1/14/18.
 */
module chapter.one {
    requires chapter.zero;

    // needed for Appendix A.
    exports com.apress.bgn.one.service;
    provides NakedService with Provider;
}