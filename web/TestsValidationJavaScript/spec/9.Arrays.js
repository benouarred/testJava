describe('Arrays', function(){

    it('Arrays - 1', function(){
        var collection = ['meaning of life', 42, true] ;
        expect(collection[0]).toBe("meaning of life");
        expect(collection[1]).toBe(42);
        expect(collection[2]).toBe(true);

    });

    it('Arrays - 2', function(){
        expect(typeof([])).toBe('object');
    });

    it('Arrays - 3', function(){
        var collection = ['a','b','c'];
        expect(collection.length).toBe(3);
    });

    it('Arrays - 4', function(){
        var daysOfWeek = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];
        var workingWeek = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'].splice(0, 5);
        expect(daysOfWeek).toEqual(['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday']);
        expect(workingWeek).toEqual(['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday']);
    });

    it('Arrays - 5', function() {
        var collection = [1,2,3,4,5,6,7,8,9];
        var odd = collection.filter(function(elem, index) {
            return elem%2 > 0;
        });
        expect(odd).toEqual([1,3,5,7,9]);
    });

    it('Arrays - 6', function() {
        var collection = [1,2,3,4];
        var result = collection.reduce(function(a, b) {
            return a*b;
        });
        expect(result).toBe(24);
    });

    it('stack methods', function(){
        var stack = [];
        stack.push("first");
        stack.push("second");
        expect(stack.pop()).toBe('second');
        expect(stack.pop()).toBe('first');
    });


});
