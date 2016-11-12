/**
 * Created by t937426 on 3/22/2016.
 */

module.exports.Factory = {
    produce : function (moduleName) {
        try {
            return require('./' + moduleName +'.js');
        } catch(err) {
            return null;
        }
    }
}