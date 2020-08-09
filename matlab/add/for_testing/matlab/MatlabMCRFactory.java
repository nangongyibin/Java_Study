/*
 * MATLAB Compiler: 6.2 (R2016a)
 * Date: Wed Jun 27 15:28:30 2018
 * Arguments: "-B" "macro_default" "-W" "java:matlab,matlab" "-T" "link:lib" "-d" 
 * "D:\\WorkSpace\\MatLab\\add\\for_testing" 
 * "class{matlab:D:\\WorkSpace\\MatLab\\add.m,D:\\WorkSpace\\MatLab\\ims.m}" 
 */

package matlab;

import com.mathworks.toolbox.javabuilder.*;
import com.mathworks.toolbox.javabuilder.internal.*;

/**
 * <i>INTERNAL USE ONLY</i>
 */
public class MatlabMCRFactory
{
   
    
    /** Component's uuid */
    private static final String sComponentId = "matlab_C9B224F5CDE4B5A8BB254FD0E0E6AB64";
    
    /** Component name */
    private static final String sComponentName = "matlab";
    
   
    /** Pointer to default component options */
    private static final MWComponentOptions sDefaultComponentOptions = 
        new MWComponentOptions(
            MWCtfExtractLocation.EXTRACT_TO_CACHE, 
            new MWCtfClassLoaderSource(MatlabMCRFactory.class)
        );
    
    
    private MatlabMCRFactory()
    {
        // Never called.
    }
    
    public static MWMCR newInstance(MWComponentOptions componentOptions) throws MWException
    {
        if (null == componentOptions.getCtfSource()) {
            componentOptions = new MWComponentOptions(componentOptions);
            componentOptions.setCtfSource(sDefaultComponentOptions.getCtfSource());
        }
        return MWMCR.newInstance(
            componentOptions, 
            MatlabMCRFactory.class, 
            sComponentName, 
            sComponentId,
            new int[]{9,0,1}
        );
    }
    
    public static MWMCR newInstance() throws MWException
    {
        return newInstance(sDefaultComponentOptions);
    }
}
