describe('About Reflection : ', function(){


    function A() {
        this.aprop = "A";
    };

    function B() {
        this.bprop = "B";
    };

    B.prototype = new A();

    it('typeof', function(){
        expect(typeof({})).toBe( _ );
        expect(typeof('apple')).toBe( _ );
        expect(typeof(-5)).toBe( _ );
        expect(typeof(false)).toBe( _ );
    });

    it("property enumeration", function() {
        var keys = [];
        var values = [];
        var person = {name: 'Thierry LAU', age: 30, unemployed: true};
        for(propertyName in person) {
            keys.push( _ );
            values.push( _);
        }
        expect(keys).toEqual(['name','age','unemployed']);
        expect(values).toEqual(['Thierry LAU', 30 , true]);
    });

    it("hasOwnProperty", function() {
        var b = new B();

        var keys = [];
        for (propertyName in b) {
            keys.push(propertyName);
        }
        expect(keys.length).toBe( _ );
        expect(keys).toEqual( _ );

        var ownKeys = [];
        for(propertyName in b) {
            if (b.hasOwnProperty(propertyName)) {
                ownKeys.push(propertyName);
            }
        }
        expect(ownKeys.length).toBe( _ );
        expect(ownKeys).toEqual( _ );
    });

    it("constructor property", function () {
        var a = new A();
        var b = new B();
        expect(typeof(a.constructor)).toBe( _ );
        expect(a.constructor.name).toBe( _ );
        expect(b.constructor.name).toBe( _ );
    });

});