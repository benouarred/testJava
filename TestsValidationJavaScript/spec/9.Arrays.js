describe('About arrays : ', function(){

    it('array literal syntax and indexing', function(){
        var collection = _ ;
        expect(collection[0]).toBe("meaning of life");
        expect(collection[1]).toBe(42);
        expect(collection[2]).toBe(true);

    });

    it('array type', function(){
        expect(typeof([])).toBe( _ );
    });

    it('array size', function(){
        var collection = ['a','b','c'];
        expect(collection._).toBe(3);
    });

    it('splice', function(){
        var daysOfWeek = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];
        var workingWeek = daysOfWeek.splice(_, _ );
        expect(daysOfWeek).toEqual( _ );
        expect(workingWeek).toEqual( _ );
    });

    it('stack methods', function(){
        var stack = [];
        stack.push("first");
        stack.push("second");
        expect(stack.pop()).toBe( _ );
        expect(stack.pop()).toBe( _ );
    });


});
