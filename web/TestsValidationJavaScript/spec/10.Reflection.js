describe('Reflection : ', function(){

    it("Reflection - 1", function() {
        var keys = [];
        var values = [];
        var person = {name: 'Thierry LAU', age: 30, unemployed: true};
        for(propertyName in person) {
            keys.push(propertyName);
            values.push(person[propertyName]);
        }
        expect(keys).toEqual(['name','age','unemployed']);
        expect(values).toEqual(['Thierry LAU', 30 , true]);
    });


    function A() {
        this.aprop = "A";
    }

    function B() {
        this.bprop = "B";
    }

    B.prototype = new A();

    it("Reflection - 2", function() {
        var b = new B();

        var keys = [];
        for (propertyName in b) {
            keys.push(propertyName);
        }
        expect(keys.length).toBe(2);
        expect(keys).toEqual(['bprop', 'aprop']);

        var ownKeys = [];
        for(propertyName in b) {
            if (b.hasOwnProperty(propertyName)) {
                ownKeys.push(propertyName);
            }
        }
        expect(ownKeys.length).toBe(1);
        expect(ownKeys).toEqual(['bprop']);
    });

    it("Reflection - 3", function () {
        var a = new A();
        var b = new B();
        expect(typeof(a.constructor)).toBe('function');
        expect(a.constructor.name).toBe('A');
        expect(b.constructor.name).toBe('A');
    });

});