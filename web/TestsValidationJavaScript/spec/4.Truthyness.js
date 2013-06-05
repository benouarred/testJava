describe('About truthyness : ', function(){

    it('of positive numbers', function(){
        var result;
        if(3){
            result = true;
        } else {
            result = false;
        }
        expect(result).toBe( _ );
    });

    it('of negative numbers', function(){
        var result;
        if(-1){
            result = true;
        } else {
            result = false;
        }
        expect(result).toBe( _ );
    });

    it('of zero', function(){
        var result;
        if(0){
            result = true;
        } else {
            result = false;
        }
        expect(result).toBe( _ );
    });

    it('of null', function(){
        var result;
        if(null){
           result = true;
        } else {
            result = false;
        }
        expect(result).toBe( _ );
    });

});