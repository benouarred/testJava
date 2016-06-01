describe('Arrays', function() {

    it('Arrays - 1', function() {
        var collection = _ ;
        expect(collection[0]).toBe("meaning of life");
        expect(collection[1]).toBe(42);
        expect(collection[2]).toBe(true);

    });

    it('Arrays - 2', function() {
        expect(typeof([])).toBe( _ );
    });

    it('Arrays - 3', function() {
        var collection = ['a','b','c'];
        expect(collection._).toBe(3);
    });

    it('Arrays - 4', function() {
        var daysOfWeek = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];
        var workingWeek = daysOfWeek.splice(_, _ );
        expect(daysOfWeek).toEqual( _ );
        expect(workingWeek).toEqual( _ );
    });

    it('Arrays - 5', function() {
        var collection = [1,2,3,4,5,6,7,8,9];
        var odd = collection.filter( _ );
        expect(odd).toEqual([1,3,5,7,9]);
    });

    it('Arrays - 6', function() {
        var collection = [1,2,3,4];
        var result = collection.reduce( _ );
        expect(result).toBe(24);
    });

    it('Arrays - 7', function() {
        var collection = [1, 2, 3];
        expect( _ ).toEqual([2, 4, 6]);
    });

    it('Arrays - 8', function() {
        var array1 = [1, 2, 3];
        var array2 = [4, 5, 6];
        expect( _ ).toEqual([1, 2, 3, 4, 5, 6]);
    });

    it('stack methods', function() {
        var stack = [];
        stack.push("first");
        stack.push("second");
        expect(stack.pop()).toBe( _ );
        expect(stack.pop()).toBe( _ );
    });

});
