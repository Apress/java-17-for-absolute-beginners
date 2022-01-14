/**
 * Created by iuliana.cosmina on 29/12/20.
 * If you decomment the open declarative, the HelloWorld#main method in chapter01 will no longer fail with InaccessibleObjectException
 */
/*open*/ module chapter.zero {
    requires transitive org.apache.logging.log4j;

    //allows reflective access to chapter.three module, to private members of package com.apress.bgn.zero; remove comment from next line and run ReflectionDemo.
    //opens com.apress.bgn.zero to chapter.three;

    //allows access to public members in package com.apress.bgn.ch0 to modules: chapter.one, chapter.three, chapter.four
    exports com.apress.bgn.zero to chapter.one, chapter.three; // chapter.four;

    // needed for Appendix A.
    //allows access to public members in package com.apress.bgn.zero.service
    exports com.apress.bgn.zero.service;
}