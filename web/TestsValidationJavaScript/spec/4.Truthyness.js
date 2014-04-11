describe('Truthyness', function(){

    it('Truthyness - 1', function(){
        var result;
        if(3){
            result = true;
        } else {
            result = false;
        }
        expect(result).toBe( _ );
    });

    it('Truthyness - 2', function(){
        var result;
        if(-1){
            result = true;
        } else {
            result = false;
        }
        expect(result).toBe( _ );
    });

    it('Truthyness - 3', function(){
        var result;
        if(0){
            result = true;
        } else {
            result = false;
        }
        expect(result).toBe( _ );
    });

    it('Truthyness - 4', function(){
        var result;
        if(null){
           result = true;
        } else {
            result = false;
        }
        expect(result).toBe( _ );
    });
	
	it('Truthyness - 5', function(){
        var result;
        if(undefined){
           result = true;
        } else {
            result = false;
        }
        expect(result).toBe( _ );
    });

});