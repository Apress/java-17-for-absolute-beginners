import com.apress.bgn.zero.service.NakedService;

/**
 * Created by iuliana.cosmina on 1/14/18.
 */
module chapter.three {
    requires chapter.zero;

    // not really needed
    //requires java.base;

    // needed for Appendix A.
    uses NakedService;
}