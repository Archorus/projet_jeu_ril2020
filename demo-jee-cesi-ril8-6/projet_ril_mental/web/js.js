

    /** Fonction basculant la visibilité d'un élément dom
     * @parameter anId string l'identificateur de la cible à montrer, cacher
     */
    function Hide (addr) { document.getElementById(addr).style.visibility = "hidden";	}
function Show (addr) { document.getElementById(addr).style.visibility = "visible";	}

function toggle(anId)
{
    if (document.getElementById(anId).style.visibility == "hidden")	{	Show(anId);	}
    else															{	Hide(anId);	}
}

window.onload = function () { Hide("creation");	};
