/*
 * MATLAB Compiler: 6.2 (R2016a)
 * Date: Wed Jun 27 15:19:29 2018
 * Arguments: "-B" "macro_default" "-W" "java:m,add" "-T" "link:lib" "-d" 
 * "D:\\WorkSpace\\MatLab\\ims\\for_testing" "class{add:D:\\WorkSpace\\MatLab\\ims.m}" 
 */

package m;

import com.mathworks.toolbox.javabuilder.*;
import com.mathworks.toolbox.javabuilder.internal.*;

/**
 * <i>INTERNAL USE ONLY</i>
 */
public class MMCRFactory
{
   
    
    /** Component's uuid */
    private static final String sComponentId = "m_997233110A70FC32AA70DF8C632B63FC";
    
    /** Component name */
    private static final String sComponentName = "m";
    
   
    /** Pointer to default component options */
    private static final MWComponentOptions sDefaultComponentOptions = 
        new MWComponentOptions(
            MWCtfExtractLocation.EXTRACT_TO_CACHE, 
            new MWCtfClassLoaderSource(MMCRFactory.class)
        );
    
    
    private MMCRFactory()
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
            MMCRFactory.class, 
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
