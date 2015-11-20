function getList()
{
  var x=new XMLHttpRequest()
  x.open("GET", "http://localhost:3000/api/todos")
  x.onload = function(e) {
    showList(JSON.parse(x.response))
  }
  x.send(null)
}

function createItem(name)
{
  var item = {description: name}
  var x=new XMLHttpRequest()
  x.open("POST", "http://localhost:3000/api/todos")
  x.onload = function(e) {
    addToList(item)
  }
  x.setRequestHeader("Content-Type", "application/json")
  x.send(JSON.stringify(item))
}

function removeItem(e)
{
  var id = e.target.parentNode.parentNode.id
  e.target.disabled=true
  var x=new XMLHttpRequest()
  x.open("DELETE", "http://localhost:3000/api/todos/"+id)
  x.onload = function(e) {
    removeFromList(id)
  }
  x.send(null)
}

function removeFromList(id)
{
  var ul = document.getElementsByTagName("ul")[0]

  ul.removeChild(document.getElementById(id).parentNode)
}

function showList(l)
{
  var ul = document.getElementsByTagName("ul")[0]
  for(var item of l)
    addToList(item)
}

function addToList(item)
{
  var ul = document.getElementsByTagName("ul")[0]
  with(ul.appendChild(document.createElement("li")))
  {
    with(appendChild(document.createElement("details")))
    {
      textContent = item.memo || ""
      id = item.id
      with(appendChild(document.createElement("summary"))) {
        textContent = item.description
        with(appendChild(document.createElement("button"))) {
          textContent = "X"
          onclick = removeItem
        }
      }
    }
  }
}


var form = document.forms[0]
form.onsubmit = function (e)
{
  e.preventDefault()
  createItem(form.nom.value)
}


getList()